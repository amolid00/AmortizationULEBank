package es.unileon.spring.web;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.springapp.web.LoanPaymentsController;
import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.assets.Loan;
import es.unileon.ulebank.assets.handler.FinancialProductHandler;
import es.unileon.ulebank.assets.strategy.loan.ScheduledPayment;
import es.unileon.ulebank.assets.support.PaymentPeriod;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.transacionManager.TransactionManager;

public class LoanPaymentsControllerTest {

	@Test
	public void testHandleRequestView() throws Exception {
		LoanPaymentsController controller = new LoanPaymentsController();

		TransactionManager manager = new TransactionManager();
		Bank bank = new Bank(manager, new GenericHandler("1234"));
		Office office = new Office(new GenericHandler("1234"), bank);
		Account commercialAccount = new Account(office, bank, "0000000000");
		GenericHandler authorizedHandler1 = new GenericHandler("Miguel");
		Client authorized1 = new Client(authorizedHandler1);
		controller.setLoan(new Loan(new FinancialProductHandler("LN", "ES"),
				10000000, 0.10, PaymentPeriod.ANNUAL, 5, commercialAccount));

		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("payments", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());

		@SuppressWarnings("unchecked")
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView
				.getModel().get("model");
		ArrayList<ScheduledPayment> paymentsValues = (ArrayList<ScheduledPayment>) modelMap
				.get("payments");
		assertNotNull(paymentsValues);
		assertTrue(paymentsValues.size() != 0);
		assertEquals(6, paymentsValues.size(), 0);
	}

}
