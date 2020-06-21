public class Contant extends Betaalwijze {
    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if (saldo - tebetalen >= 0) {
            saldo = saldo - tebetalen;
        } else {
            throw new TeWeinigGeldException("Te weinig saldo");
        }
    }

    @Override
    public String toString() {
        return "Contant";
    }
}
