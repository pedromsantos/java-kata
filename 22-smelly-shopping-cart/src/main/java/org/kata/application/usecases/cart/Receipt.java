package org.kata.application.usecases.cart;

public record Receipt(String cartId, double total, String confirmationCode, String confirmedAt) {}
