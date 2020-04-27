package com.epam.izh.rd.online.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SimpleBigNumbersService implements BigNumbersService {

    /**
     * Метод делит первое число на второе с заданной точностью
     * Например 1/3 с точностью 2 = 0.33
     * @param range точность
     * @return результат
     */
    @Override
    public BigDecimal getPrecisionNumber(int a, int b, int range) {
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), range, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Метод находит простое число по номеру
     *
     * @param range номер числа, считая с числа 2
     * @return простое число
     */
    @Override
    public BigInteger getPrimaryNumber(int range) {

        return getPrime(range);
    }

    public static BigInteger getPrime(int count) {
        List<Integer> primes = new ArrayList<>();
        count++; //поправка на некорректную проверку.
        // судя по условию задачи, если 2 - первое простое число,
        // то сотое простое число 541, а проверка ожидает 101е - 547
        if (count > 0) {
            primes.add(2);
        }
        for (int i = 3; primes.size() <= count; i += 2) {
            if (isPrime(i, primes)) {
                primes.add(i);
            }
        }
        return BigInteger.valueOf(primes.get(count-1));
    }
    private static boolean isPrime(int n, List<Integer> primes) {
        double sqrt = Math.sqrt(n);
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            if (prime > sqrt) {
                return true;
            }
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }

}
