public abstract class Betaalwijze {

    // Opdracht 1c:
    // Zodat de variabel door de child class ge-accessed kan worden,
    // het is handig zodat je de variabel niet twee keer hoeft aan te maken.
    protected double saldo;

    /**
     * Methode om krediet te initialiseren
     *
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     * Methode om betaling af te handelen
     *
     * @param tebetalen
     * @return Boolean om te kijken of er voldoende saldo is
     */
    public abstract boolean betaal(double tebetalen);
}
