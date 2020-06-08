public class Theorie {
    /*
    Opdracht 3:
    A: Nee dat kan niet, omdat een interface een abstracte klasse is en heeft geen constructor dus kun je er geen
        instantie van maken.
    B: Nee dat kan niet, omdat de abstract klasse restricted is kan je er alleen bij als je geërfd hebt van een andere
        klasse.
    C: Nee
    D: Ja
    E: Ja
    F: Ja dat klopt, als een klasse een interface implementeerd moet elke methode worden overschreven en dus zijn alle
        methodes abstract.
    G: Ja, omdat abstracte methodes alleen in een abstracte klasse kan worden gebruikt.
    H: Polymorfism is dat een object verschillende vormen heeft en je kunt er achterkomen als een object meer dan
        één IS-A test haald. Voorbeeld
        public interface Vegetarian{}
        public abstract class Animal{}
        public class Panda extends Animal implements Vegetarian{}

        A Panda IS-A Animal
        A Panda IS-A Vegetarian
        A Panda IS-A Panda
        A Panda IS-A Object

    Opdracht 4:
    A: Ja dat kan, niet elke methode hoeft abstract te zijn. De methodes hoeven dan niet worden overschreven maar
        dat kan wel.
    B: Ja, omdat abstracte methodes geen body hebben, moeten de sub klassen die zelf implementeren.
    C: Je kunt de klasse abstract maken. Een abstracte klasse kan dan de methodes laten implementeren door de sub klassen.
    D: Je kunt geërfde velden niet overschrijven daarom kunnen ze niet abstract zijn.
    E: Een final methode kan niet worden veranderd door een buitenstaander, dus ook niet sub klassen.
        Het is logisch, want met abstract moet je het overerven en met final kan je het niet overerven, want het mag niet
        veranderd worden.
    */
}
