import com.sun.istack.internal.Nullable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import java.io.IOException;

public class JHello {

    private int point;

    public String utterGreeting() {
        return "Hello";
    }

    @Nullable
    public String utterWords() {
        return null;
    }

    public int getPoint() {
        System.out.println("getPoint:" + point);
        return point;
    }

    public void setPoint(int point) {
        System.out.println("setPoint:" + point);
        this.point = point;
    }

    public static void main(String[] args) {
        //System.out.println(HelloKt.greeting());
        System.out.println(Hello.greeting());
        Spellbook spellbook = new Spellbook();
        //spellbook.getSpells()
        //@JvmField注解后直接使用属性
        for(String spell : spellbook.spells) {
            System.out.println(spell);
        }

        Hello.showInfo("abc");

        //伴生对象
        //Spellbook.Companion.getMAX_SPELL_COUNT();
        System.out.println(Spellbook.MAX_SPELL_COUNT);
        Spellbook.getSpellbookGreeting();

        try {
            new JHello().throwException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Hello.throwException();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Function1<String, Unit> translator = HelloKt.getTranslator();
        translator.invoke("TRUE");
    }

    public void throwException() throws IOException {
        throw new IOException();
    }
}
