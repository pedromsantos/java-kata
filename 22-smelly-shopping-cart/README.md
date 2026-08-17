# Legacy Code & Test Smells Kata - Shopping Cart

## Overview

This kata is a **fixture, not a from-scratch TDD exercise**. It has the same
objective as `21-smelly-mars-rover`, but with a more everyday domain: a
shopping cart (inspired by `24-shopping-cart`), built across the same
Domain/Application/Infrastructure layers, deliberately as legacy code. It
exists to practice (or to exercise tooling for):

- detecting legacy testability blockers and choosing a seam or fallback
  strategy
- characterization testing of code with no tests and no documentation
- detecting and refactoring test smells in an existing, badly-tested suite
- deciding, for one codebase, which parts need "add tests" work and which
  parts need "fix the existing tests" work

Unlike `16-smelly` (which bakes in **production code smells** to refactor),
this kata bakes in **testability blockers** and **test smells** -- the two
things that make legacy code hard to safely add tests to.

Unlike `21-smelly-mars-rover`, which is a small handful of classes in one
package, this kata is laid out across the three layers of a small hexagonal
application (`org.kata.domain`, `org.kata.application`,
`org.kata.infrastructure`) so you can practice all three test types on the
same codebase: acceptance, unit, and integration.

None of the production or test classes contain explanatory comments. Finding
and naming each blocker and each smell is part of the exercise -- this
README intentionally does not say where they are.

## Current State

| Layer              | Coverage           | What's wrong                                                          |
| ------------------ | ------------------- | ---------------------------------------------------------------------- |
| Domain             | mixed, partial      | no test deliberately targets the `Cart` aggregate's core behavior      |
| Application         | partial              | `AddProductToCart` has no tests at all                                |
| Domain (services)  | tested               | tests exist, but nearly all are smelly                                |
| Infrastructure     | tested               | tests exist, but nearly all are smelly                                |

## Problem Description

A customer builds a cart by adding products from this catalogue:

| Code    | Name       | Price   |
| ------- | ---------- | ------- |
| VOUCHER | Voucher    | 5.00 €  |
| TSHIRT  | T-Shirt    | 20.00 € |
| MUG     | Coffee Mug | 7.50 €  |

Two promotions apply when the subtotal is calculated:

1. **Buy One Get One Free (2-for-1)** on `VOUCHER` items.
2. **Bulk Purchase Discount** on `TSHIRT` items: 3 or more drops the unit
   price to 19.00 €.

Checking out is the full end-to-end flow: load a cart, price it, generate an
order confirmation code, timestamp it, and email the customer a
confirmation. That flow is the acceptance-level seam for this kata
(`CheckoutCart`).

## What to Look For

The application layer has several deliberate testability blockers -- things
that make a class hard or impossible to put under test as-is. Before writing
a single test, identify each one and name it using a legacy-code
testability taxonomy of your choice (constructor does real work, hardcoded
dependency, singleton/global state, static method with a side effect,
non-determinism with no seam, etc.). There are more blockers here than in
`21-smelly-mars-rover`, spread across two layers.

The domain aggregate at the center of this kata (`Cart`) is never
deliberately tested either, even though it looks, at first glance, like it
has decent coverage -- look closely at _which_ of its methods are actually
exercised, and by what.

The existing unit and integration test suites both currently pass, but both
are deliberately smelly. Together they represent every smell from this
catalogue at least once, and you'll see several of them show up differently
depending on whether they're in a unit test or an integration test:

Logic in Test, Mock Overuse, Test Interdependence, Fragile Test, Mystery
Guest, Eager Test, Assertion Roulette, Obscure Test, Test Code Duplication,
Conditional Test Logic, Hard-Coded Test Data, Testing Private Methods, Slow
Unit Test, Mocking Final/Concrete Classes, Mocking Value Objects,
Implementation Coupling, Shared Mutable State, Port-Boundary Violations,
Testing Theater.

Some smells overlap in the same test. None of them are labeled in the code.

## Tasks

Pick one direction (or all three, on separate branches):

1. **Write the missing acceptance test, outside-in** -- if you were adding
   coverage from scratch, you'd start here: create a cart, add products,
   check out, assert on the receipt -- then decide what seam each hardcoded
   dependency needs before any of that is even possible. (An acceptance
   test already exists in this fixture; treat it as a worked example of
   what "outside-in" looks like, then apply the same approach to the parts
   that still have none.)
2. **Fix the existing unit tests** -- everything under
   `domain/services/*UnitTest.java` currently passes, but almost none of it
   protects real behavior. Detect each smell, then refactor it without ever
   weakening or deleting a test to make it pass.
3. **Fix the existing integration tests** -- same exercise, but for
   `infrastructure/repositories/InMemoryShoppingCartRepositorySmellyIntegrationTest.java`
   and `infrastructure/gateways/EmailNotificationGatewayIntegrationTest.java`.
   Pay attention to how the same smell can look different against a
   repository than it does against a domain service. Compare it against
   `ShoppingCartRepositoryIntegrationTest.java`, a cleaner integration test
   against the same repository, to see the difference clean-up makes.

## Tips

- Do not fix a testability blocker and add new tests in the same change --
  seam refactors are a separate, behavior-preserving change from test
  additions.
- The smelly tests currently pass. That is the point: passing is not the
  same as protecting anything.
- Run mutation testing after any test addition or fix -- high coverage with
  weak assertions is exactly what several of the smells above look like
  from the outside.

## Testing

This module uses JUnit 5 and AssertJ, with Mockito available for test
doubles (matching the style of the pre-written smelly tests, which use
Mockito the way the original TypeScript kata uses Jest mocks).
