package org.example.strategy;

/*

# LLD Practice Problem: Payment Processing System

Level: Beginner → SDE-2 Language: Java Time limit: 45 minutes

## Problem statement

You are developing a payment system for an e-commerce application. Customers can pay for their orders using different payment methods.

The system must support the following payment methods:

1. Credit Card — process a payment using a card number and CVV.
2. UPI — process a payment using a UPI ID.
3. Wallet — process a payment using a wallet account.

Each payment method has its own payment-processing logic.

## Requirements

1. Create a `PaymentService` that accepts a payment method and an amount.
2. The customer should be able to choose any supported payment method at runtime.
3. Each payment method must implement its own payment-processing logic.
4. Every payment must return a result indicating whether it succeeded or failed, along with a transaction ID when applicable.
5. The payment amount must be greater than zero.
6. If an unsupported payment method is provided, the system must handle it gracefully.
7. The design should allow a new payment method to be added without modifying the existing payment-processing logic.
8. Write a simple `main()` method to demonstrate payments using all three methods.

## Constraints

- Use Java 17.
- Do not use Spring Boot or any external libraries.
- Keep the code simple and readable.
- Do not implement a database or a real payment gateway.
- Simulate payment processing by printing messages and returning results.

## Your task

Implement the complete solution, including the classes, interfaces, and a runnable `main()` method.

Do not worry about advanced concerns such as concurrency, retries, refunds or distributed transactions yet.

Once you share your code, I'll review it as an interviewer and ask you follow-up questions one at a time.
 */


record PaymentRequest(
    String paymentType,

     Double amount,

   String cardNumber,

  Integer cvv,

   String upiId
){

}

class PaymentServiceV2{
     private PaymentRequest request;

     private FactoryPayments factoryPayments;
    PaymentServiceV2(PaymentRequest request)
    {
        this.request = request;
        this.factoryPayments = new FactoryPayments();
    }

    void processPaymentMethods()
    {
       var paymentMode =  factoryPayments.processFactory(request.paymentType());
       paymentMode.payment(request);
    }


}

class FactoryPayments{

    PaymentV2 processFactory(String paymentType) {
        switch (paymentType.toLowerCase())
        {
            case "credit" : return new CreditCard();
            case "wallet" : return new WalletV2();
            case "upi": return new UPIV2();
            default: throw new RuntimeException("Not a valid paymentType");
        }
    }
}

class CreditCard implements PaymentV2{

    @Override
    public void payment(PaymentRequest request) {
        if(request.amount()<=0 && request.amount()==null){
            System.out.println("Not a valid amount");
        }
        if(request.cardNumber().startsWith("SBI"))
        {
            System.out.println("Valid card number" + "Enter cvv");
        }
        else
        {
            throw new RuntimeException("not a valid card ");
        }
        System.out.println("Process payment Through credit card");
    }
}
class WalletV2 implements PaymentV2{

    @Override
    public void payment(PaymentRequest request) {
        System.out.println("Debited through wallet");
    }
}
class UPIV2 implements  PaymentV2
{

    @Override
    public void payment(PaymentRequest request) {
        if(!request.upiId().contains("@upi"))
        {
            System.out.println("Not a valid upi type");
        }
        System.out.println("Payment through UPI");
    }
}
interface PaymentV2{
    void payment(PaymentRequest request);

}

public class StrategyV2 {

    public static void main(String[] args)
    {

       PaymentRequest request = new PaymentRequest(
               "UPI",
               98000.0,
               null,
               null,
               "aksj@upi"
       );

        PaymentRequest request2 = new PaymentRequest(
                "Credit",
                980900.0,
                "SBI9090909",
                234,
                "aksj@upi"
        );

        PaymentRequest request3 = new PaymentRequest(
                "Razorpay",
                98000.0,
                null,
                null,
                "aksj@upi"
        );

        PaymentServiceV2 serviceV2 = new PaymentServiceV2(request);
        PaymentServiceV2 serviceV2a = new PaymentServiceV2(request2);
        PaymentServiceV2 serviceV2b = new PaymentServiceV2(request3);
        serviceV2.processPaymentMethods();
        serviceV2a.processPaymentMethods();
        serviceV2b.processPaymentMethods();

    }

}
