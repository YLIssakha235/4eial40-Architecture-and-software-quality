package be.ecam.basics.exercises;

import java.util.Objects;

public class Account {
    private long balance; // balance en centimes
    // on change le type de balance de double a long pour eviter les erreurs d'arrondis

    public Account() { this(0.0); }

    public Account(double initial) {
        if (initial < 0.0) throw new IllegalArgumentException("initial");
        this.balance = Math.round(initial * 100.0);
    }

    public double getBalance() {
        return balance / 100.0;
    }

    public void deposit(double amount) {
        if (amount < 0.0) throw new IllegalArgumentException("amount");
        long delta = Math.round(amount * 100.0);
        this.balance += delta;
    }

    public void withdraw(double amount) {
        if (amount < 0.0) throw new IllegalArgumentException("amount");
        long delta = Math.round(amount * 100.0);
        if (delta > this.balance) throw new IllegalStateException("insufficient");
        this.balance -= delta;
    }

    public void transferTo(Account other, double amount) {
        Objects.requireNonNull(other, "other");
        withdraw(amount);
        other.deposit(amount);
    }
}