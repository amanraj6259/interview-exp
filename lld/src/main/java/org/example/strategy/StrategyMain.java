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

//Entity class
class PaymentEntity{
    int payId;

    String paymentType;

    Double amount;
}

interface Payment{
    void makePayment();
}

class Debit implements Payment{

    @Override
    public void makePayment() {
        System.out.println("Debited through debit card");
    }

    public void processUsingCardNumber(String cardNumber)
    {
        System.out.println("Valid card Number" + cardNumber);
    }
}

class Credit implements Payment{

    @Override
    public void makePayment() {
        System.out.println("Debited through credit card");
    }
}

class UPI implements Payment{

    @Override
    public void makePayment() {
        System.out.println("Debited through upi card");
    }
}

class Wallet implements  Payment{

    @Override
    public void makePayment() {
        System.out.println("Debited through wallet card");

    }
}

class FactoryPayment
{
    private Payment payment;
    String type;
    FactoryPayment(String type){
        this.type = type;
    }

    Payment procesPayement(String type)
    {
        switch(type.toLowerCase())
        {
            case "debit" :{
                return new Debit();
                //how should i process debit


            }
            case "upi" :{
                return new UPI();
                //how should i process debit
            }
            case "wallet":{
                return new Wallet();
            }

            default:{
                System.out.println("Invalid type");
                throw new RuntimeException("Not  a valid type");

            }


    }
    }


}


class PaymentService{

    private Payment payment;

    String paymentType;

    Double amount;

    PaymentService(Payment payment,String paymentType,Double amount)
    {
        this.payment = payment;
        this.amount=amount;
        this.paymentType=paymentType;

        payment.makePayment();
    }

    //without stategy
    String makePayment()
    {
        if(amount==null || amount<=0.0)
        {
            throw new RuntimeException("Invalid data type");

        }
        if(paymentType.equalsIgnoreCase("Debit"))
        {
            System.out.println("Debited through debit card");
            return "Debit amount through debit card and trxn id DB456";
        }
        else if(paymentType.equalsIgnoreCase("UPI"))
        {
            System.out.println("UPI payment through UPI");
            return "Debit amount through UPI card and trxn id DB456";

        }
        return "Invalid paymentType";

    }


    void printSalarySlip()
    {
        System.out.println("Salary slip printed");
    }

}

class PaymentServiceWithFactoryStrategy{

    private FactoryPayment factoryPayment;
    String paymentType;

    Double amount;

    PaymentServiceWithFactoryStrategy(String paymentType,Double amount)
    {

        this.amount=amount;
        this.paymentType=paymentType;
        this.factoryPayment = new FactoryPayment(paymentType);

    }



    //without stategy
    String makePayment()
    {
        var payment = factoryPayment.procesPayement(paymentType);
        payment.makePayment();
        if(amount==null || amount<=0.0)
        {
            throw new RuntimeException("Invalid data type");

        }
        return "PAYMENTTYPE with txnId" +  paymentType;

    }

    void printSalarySlip()
    {
        System.out.println("Salary slip printed");
    }

}

public class StrategyMain {
    public static void main(String[] args)
    {
        //wuithout startegy
//        PaymentService paymentService = new PaymentService("Debit",350.0);
//        PaymentService paymentService2 = new PaymentService("UPI",750.0);
//        PaymentService paymentService3 = new PaymentService("NetBanking",350.0);
//        System.out.println(paymentService.makePayment() + " " +  paymentService2.makePayment() + " " + paymentService3.makePayment());
        //now using strategy
        PaymentService py = new PaymentService(new UPI(), "UPI", 890.0);
        PaymentService py1 = new PaymentService(new Debit(),"Debit", 900.0);

        //using strategy and factort
        PaymentServiceWithFactoryStrategy p1 = new PaymentServiceWithFactoryStrategy("Debit",350.0);
        PaymentServiceWithFactoryStrategy p2 = new PaymentServiceWithFactoryStrategy("RazorPay",350.0);
        p1.makePayment();
        p2.makePayment();





    }
}
