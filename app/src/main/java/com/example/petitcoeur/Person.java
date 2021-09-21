package com.example.petitcoeur;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

enum Genre {
    MAN,
    WOMAN,
    OTHER,
    UNDEFINED
}
enum Response {
    Yes,
    No
}

/**
 * Class storing data fetched through activities.
 * Must implement Parcelable to be used with Intents.
 * https://developer.android.com/reference/android/os/Parcelable#java
 */
public class Person implements Parcelable {
    private String name;
    private Genre genre;
    private int age;
    private Response heartCondition;
    public static final String DEFAULT_NAME = "UNDEFINED";
    private Response diabetic;
    private Response cholesterol;
    private Response first_degree_relative;

    /**
     * Constructor. All members get default values
     */
    public Person() {
        this.setName(Person.DEFAULT_NAME);
        this.setGenre(Genre.UNDEFINED);
        this.setAge(0);
        this.setCardiacCheckUp(false);
    }
    /**
     * @return the description of this class as a String
     */
    @NonNull
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("\t Name: " + this.getName() + "\n");
        sBuilder.append("\t Genre: ").append(this.getGenre()).append("\n");
        sBuilder.append("\t Age: ").append(this.getAge()).append("\n");
        sBuilder.append("\t Cardiac Checkup: ").append(this.getCardiacCheckUp()).append("\n");
        return sBuilder.toString();
    }
    /**
     * Display this instance's contents
     */
    public void print() {
        System.out.println("Person's attributes: ");
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
public Boolean getCardiacCheckUp() { return this.cardiacCheckUp; }
public void setCardiacCheckUp(Boolean aCardiacCheckUp) {
        this.cardiacCheckUp = aCardiacCheckUp;
        }
@Override // Parcelable method
public int describeContents() { return 0;}
@Override // Parcelable method
public void writeToParcel(Parcel dest, int flags) {
// Both reading and writing orderings must match (see Person(Parcel in) method)
        dest.writeString(this.getName());
        dest.writeInt(this.getGenre().ordinal());
        dest.writeInt(this.getAge());
// dest.writeBoolean() requires API 29
// If the error "current min is set to <Number lesser than 29>"
// => Edit Gradle scripts -> build.gradle (Module: YourApp.app)
// ==> change "minSdK <Number lesser than 29>" to "minSdk 29"
// (this SDK must be installed)
        dest.writeBoolean(this.getCardiacCheckUp());
        }
/**
 * https://developer.android.com/reference/android/os/Parcelable#java
 */
public static final Parcelable.Creator<Person> CREATOR
        = new Parcelable.Creator<Person>() {
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
private Person(Parcel in) {
// Both reading and writing orderings must match (see writeToParcel method)
        this.setName(in.readString());
        this.setGenre(Genre.values()[in.readInt()]);
        this.setAge(in.readInt());
        this.setCardiacCheckUp(in.readBoolean());
        }
        }
