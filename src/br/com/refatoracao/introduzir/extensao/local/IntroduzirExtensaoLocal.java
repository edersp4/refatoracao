package br.com.refatoracao.introduzir.extensao.local;

import java.time.Instant;
import java.util.Date;

public class IntroduzirExtensaoLocal {
    public static void main(String[] args) {
        Date proximoDia = new MfDateSub().proximoDia();
        System.out.println(proximoDia);


        Date wrap = new DateWrap().proximoDia();

        System.out.println(wrap);
    }
}

/**
 * Usando SubClasse
 */
class MfDateSub extends Date {
    public MfDateSub() {
        super();
    }

    public MfDateSub(long date) {
        super(date);
    }

    public MfDateSub(int year, int month, int date) {
        super(year, month, date);
    }

    public MfDateSub(int year, int month, int date, int hrs, int min) {
        super(year, month, date, hrs, min);
    }

    public MfDateSub(int year, int month, int date, int hrs, int min, int sec) {
        super(year, month, date, hrs, min, sec);
    }

    public MfDateSub(String s) {
        super(s);
    }

    public Date proximoDia() {
        return new Date(getYear(), getMonth(), getDate() + 1);
    }
}

/**
 * Usando o envoltório
 */
class DateWrap {

    private Date original;
    public DateWrap() {
        original = new Date();
    }

    public DateWrap(long date) {
        original = new Date(date);
    }

    public DateWrap(int year, int month, int date) {
       original = new Date(year, month, date);
    }

    public DateWrap(int year, int month, int date, int hrs, int min) {
        original = new Date(year, month, date, hrs, min);
    }

    public DateWrap(int year, int month, int date, int hrs, int min, int sec) {
       original = new Date (year, month, date, hrs, min, sec);
    }

    public DateWrap(String s) {
        original = new Date(s);
    }

    @Deprecated
    public static long UTC(int year, int month, int date, int hrs, int min, int sec) {
        return Date.UTC(year, month, date, hrs, min, sec);
    }

    @Deprecated
    public static long parse(String s) {
        return Date.parse(s);
    }

    @Deprecated
    public int getYear() {
        return original.getYear();
    }

    @Deprecated
    public void setYear(int year) {
        original.setYear(year);
    }

    @Deprecated
    public int getMonth() {
        return original.getMonth();
    }

    @Deprecated
    public void setMonth(int month) {
        original.setMonth(month);
    }

    @Deprecated
    public int getDate() {
        return original.getDate();
    }

    @Deprecated
    public void setDate(int date) {
        original.setDate(date);
    }

    @Deprecated
    public int getDay() {
        return original.getDay();
    }

    @Deprecated
    public int getHours() {
        return original.getHours();
    }

    @Deprecated
    public void setHours(int hours) {
        original.setHours(hours);
    }

    @Deprecated
    public int getMinutes() {
        return original.getMinutes();
    }

    @Deprecated
    public void setMinutes(int minutes) {
        original.setMinutes(minutes);
    }

    @Deprecated
    public int getSeconds() {
        return original.getSeconds();
    }

    @Deprecated
    public void setSeconds(int seconds) {
        original.setSeconds(seconds);
    }

    public long getTime() {
        return original.getTime();
    }

    public void setTime(long time) {
        original.setTime(time);
    }

    public boolean before(Date when) {
        return original.before(when);
    }

    public boolean after(Date when) {
        return original.after(when);
    }

    public int compareTo(Date anotherDate) {
        return original.compareTo(anotherDate);
    }

    @Deprecated
    public String toLocaleString() {
        return original.toLocaleString();
    }

    @Deprecated
    public String toGMTString() {
        return original.toGMTString();
    }

    @Deprecated
    public int getTimezoneOffset() {
        return original.getTimezoneOffset();
    }

    public static Date from(Instant instant) {
        return Date.from(instant);
    }

    public Instant toInstant() {
        return original.toInstant();
    }

    public Date proximoDia() {
        return new Date(getYear(), getMonth(), getDate() + 1);
    }
}
