package com.example.petitcoeur;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

enum Genre {
    MAN,
    WOMAN,
    OTHER,
    UNDEFINED
}
enum Response {
    Yes,
    No,
    Undefined
}

/**
 * Class storing data fetched through activities.
 * Must implement Parcelable to be used with Intents.
 * https://developer.android.com/reference/android/os/Parcelable#java
 */
public class Person implements Parcelable {
    private String name; // nom patient
    public static final String DEFAULT_NAME = "UNDEFINED"; // Nom defini par defaut
    private Genre genre; // sexe patient
    private int age; // age patient
    private Response heartCondition; // si probleme cardiaque
    private Response diabetic; // si diabetique
    private Response cholesterol; // si cholesterol
    private Response firstDegreeRelative; // si antecedant familieux
    private String cardiovascularCheck; // si le patient a fait un check-up cardiaque
    public static final String DEFAULT_CARDIO_CHECK = "UNDEFINED"; // Cardiovascular Check defini par defaut
    private Boolean cardiovascularRisk; // si le patient a des rsiques vasculaires
    private String consultCardiologist; // Si le patient a consulter un cardiologue
    public static final String DEFAULT_CONSULT = "UNDEFINED";
    private Response alcool;
    private Response energisant;
    private Response heuresSommeil;
    private Response troublesSommeil;


    /**
     * Constructor. All members get default values
     */
    public Person() {
        this.setName(Person.DEFAULT_NAME);
        this.setGenre(Genre.UNDEFINED);
        this.setAge(0);
        this.setHeartCondition(Response.Undefined);
        this.setDiabetic(Response.Undefined);
        this.setCholesterol(Response.Undefined);
        this.setFirstDegreeRelative(Response.Undefined);
        this.setCardiovascularCheck(Person.DEFAULT_CARDIO_CHECK);
        this.setCardiovascularRisk(false);
        this.setConsultCardiologist(Person.DEFAULT_CONSULT);
        this.setAlcool(Response.Undefined);
        this.setEnergisant(Response.Undefined);
        this.setHeuresSommeil(Response.Undefined);
        this.setTroublesSommeil(Response.Undefined);
    }
    /**
     * @return the description of this class as a String
     */
    @NonNull
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("\t Name: " + this.getName() + "\n");
        sBuilder.append("\t Genre: ").append(this.getGenre()).append("\n");
        sBuilder.append("\t Age: ").append(this.getAge()).append("\n");
        sBuilder.append("\t Heart Condition: ").append(this.getHeartCondition()).append("\n");
        sBuilder.append("\t Diabetic: ").append(this.getDiabetic()).append("\n");
        sBuilder.append("\t Cholesterol: ").append(this.getCholesterol()).append("\n");
        sBuilder.append("\t First Degree Relative: ").append(this.getFirstDegreeRelative()).append("\n");
        sBuilder.append("\t Cardiovascular Check: ").append(this.getCardiovascularCheck()).append("\n");
        sBuilder.append("\t Cardiovascular Risk: ").append(this.getCardiovascularRisk()).append("\n");
        sBuilder.append("\t Consult Cardiologist: ").append(this.getConsultCardiologist()).append("\n");
        sBuilder.append("\t Consommation Alcool: ").append(this.getAlcool()).append("\n");
        sBuilder.append("\t Consommation Energisant: ").append(this.getEnergisant()).append("\n");
        sBuilder.append("\t 7 Heures de Sommeil: ").append(this.getHeuresSommeil()).append("\n");
        sBuilder.append("\t Troubles du Sommeil: ").append(this.getTroublesSommeil()).append("\n");
        return sBuilder.toString();
    }
    /**
     * Display this instance's contents
     */
    public void print() {
        System.out.println("Patient's attributes: ");
        System.out.print(this);
        System.out.println();
    }
    /*
* Getters / Setters
        */
public String getName() { return this.name; }
public void setName(String aName) { this.name = aName; }

public Genre getGenre() { return this.genre; }
public void setGenre(Genre aGenre) { this.genre = aGenre; }

public int getAge() { return this.age; }
public void setAge(int anAge) { this.age = anAge; }

public Response getHeartCondition() { return this.heartCondition; }
public void setHeartCondition(Response aHeartCondition) { this.heartCondition = aHeartCondition; }

public Response getDiabetic() { return this.diabetic; }
public void setDiabetic(Response aDiabetic) { this.diabetic = aDiabetic; }

public Response getCholesterol() { return this.cholesterol; }
public void setCholesterol(Response aCholesterol) { this.cholesterol = aCholesterol; }

public Response getFirstDegreeRelative() { return this.firstDegreeRelative; }
public void setFirstDegreeRelative(Response aFirstDegreeRelative) { this.firstDegreeRelative = aFirstDegreeRelative; }

public String getCardiovascularCheck() { return this.cardiovascularCheck; }
public void setCardiovascularCheck(String aCardiovascularCheck) { this.cardiovascularCheck = aCardiovascularCheck; }

public Boolean getCardiovascularRisk() { return this.cardiovascularRisk; }
public void setCardiovascularRisk(Boolean aCardiovascularRisk) {
    this.cardiovascularRisk = aCardiovascularRisk;
}

public String getConsultCardiologist() { return this.consultCardiologist; }
public void setConsultCardiologist(String aConsultCardiologist) { this.consultCardiologist = aConsultCardiologist; }

public Response getAlcool() { return this.alcool; }
public void setAlcool(Response anAlcool) { this.alcool = anAlcool; }

public Response getEnergisant() { return this.energisant; }
public void setEnergisant(Response anEnergisant) { this.energisant = anEnergisant; }

public Response getHeuresSommeil() { return this.heuresSommeil; }
public void setHeuresSommeil(Response aHeuresSommeil) { this.heuresSommeil = aHeuresSommeil; }

public Response getTroublesSommeil() { return this.troublesSommeil; }
public void setTroublesSommeil(Response aTroublesSommeil) { this.troublesSommeil = aTroublesSommeil; }

@Override // Parcelable method
public int describeContents() { return 0;}
@RequiresApi(api = Build.VERSION_CODES.Q)
@Override // Parcelable method
public void writeToParcel(Parcel dest, int flags) {
// Both reading and writing orderings must match (see Person(Parcel in) method)
// dest.writeBoolean() requires API 29
// If the error "current min is set to <Number lesser than 29>"
// => Edit Gradle scripts -> build.gradle (Module: YourApp.app)
// ==> change "minSdK <Number lesser than 29>" to "minSdk 29"
// (this SDK must be installed)
        dest.writeString(this.getName());
        dest.writeInt(this.getGenre().ordinal());
        dest.writeInt(this.getAge());
        dest.writeInt(this.getHeartCondition().ordinal());
        dest.writeInt(this.getDiabetic().ordinal());
        dest.writeInt(this.getCholesterol().ordinal());
        dest.writeInt(this.getFirstDegreeRelative().ordinal());
        dest.writeString(this.getCardiovascularCheck());
        dest.writeBoolean(this.getCardiovascularRisk());
        dest.writeString(this.getConsultCardiologist());
        dest.writeInt(this.getAlcool().ordinal());
        dest.writeInt(this.getEnergisant().ordinal());
        dest.writeInt(this.getHeuresSommeil().ordinal());
        dest.writeInt(this.getTroublesSommeil().ordinal());
}
/**
 * https://developer.android.com/reference/android/os/Parcelable#java
 */
public static final Parcelable.Creator<Person> CREATOR
        = new Parcelable.Creator<Person>() {
@RequiresApi(api = Build.VERSION_CODES.Q)
public Person createFromParcel(Parcel in) {
        return new Person(in);
        }
public Person[] newArray(int size) {
        return new Person[size];
        }
        };
/**
 * https://developer.android.com/reference/android/os/Parcelable#java
 */
@RequiresApi(api = Build.VERSION_CODES.Q)
private Person(Parcel in) {
// Both reading and writing orderings must match (see writeToParcel method)
        this.setName(in.readString());
        this.setGenre(Genre.values()[in.readInt()]);
        this.setAge(in.readInt());
        this.setHeartCondition(Response.values()[in.readInt()]);
        this.setDiabetic(Response.values()[in.readInt()]);
        this.setCholesterol(Response.values()[in.readInt()]);
        this.setFirstDegreeRelative(Response.values()[in.readInt()]);
        this.setCardiovascularCheck(in.readString());
        this.setCardiovascularRisk(in.readBoolean());
        this.setConsultCardiologist(in.readString());
        this.setAlcool(Response.values()[in.readInt()]);
        this.setEnergisant(Response.values()[in.readInt()]);
        this.setHeuresSommeil(Response.values()[in.readInt()]);
        this.setTroublesSommeil(Response.values()[in.readInt()]);
        }
}
