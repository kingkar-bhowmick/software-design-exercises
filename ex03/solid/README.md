## Overview

This repository contains the example code for the SOLID exercise block. All examples are written in plain Java and can be executed from the command line or any IDE.

The accompanying exercise sheet is not part of the repository. You will find it in the Moodle course that belongs to this module.

## Code Structure

- `src/main/java/shop/app/App.java`: main application that runs all demos.
- `src/main/java/shop/checkout`: shopping-cart domain (`Cart`, `CartItem`, `CheckoutService`).
- `src/main/java/shop/billing`: invoice-related logic (`Invoice`, `InvoiceApp`).
- `src/main/java/shop/billing/export`: infrastructure helper that renders invoices into PDFs.
- `src/main/java/shop/notification`: reusable email abstractions (`Message`, `MailNotifier`).
- `lib`: optional third-party dependencies (empty by default).
- `bin`: compilation output when you run `javac -d bin $(find src/main/java -name '*.java')`.

## Working with the Code

Use the demos as a starting point to practice the required refactorings:

1. Explore the checkout service and identify SRP violations before and after your changes.
2. Introduce dependency-inversion abstractions around invoice rendering and notifications inside the billing packages.
3. Run `java -cp bin shop.app.App` to validate that your refactorings keep the behaviour intact.

Refer to the Moodle exercise sheet for detailed tasks and discussion.
