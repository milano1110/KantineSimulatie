public class Pinpas extends Betaalwijze {

    private double kredietlimiet;

    /**
     * Methode om kredietlimiet te zetten
     *
     * @param kredietlimiet
     */
    public void setKredietLimiet(double kredietlimiet) {
        this.kredietlimiet = kredietlimiet;
    }

    /**
     * Methode om betaling af te handelen
     */
    public void betaal(double tebetalen) throws TeWeinigGeldException {
        if (tebetalen >= kredietlimiet && saldo - tebetalen >= 0) {
            saldo = saldo - tebetalen;
        } else {
            throw new TeWeinigGeldException("Te weinig saldo");
        }
    }

    @Override
    public String toString() {
        return "Pinpas";
    }
}
