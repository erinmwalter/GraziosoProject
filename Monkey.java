
public class Monkey extends RescueAnimal{
	//instance string
	private String species;
	private String tailLength;
	private String height;
	private String bodyLength;
	
	
	//constructor, user input fed into this from driver
	public Monkey(String name, String species, String gender, String age,
	String weight, String monkeyHeight, String tail, String body, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
		setName(name);
		setSpecies(species);
		setGender(gender);
		setAge(age);
		setWeight(weight);
		setHeight (monkeyHeight);
		setTailLength(tail);
		setBodyLength(body);
		setAcquisitionDate(acquisitionDate);
		setAcquisitionLocation(acquisitionCountry);
		setTrainingStatus(trainingStatus);
		setReserved(reserved);
		setInServiceCountry(inServiceCountry);

		    }
	
	// Accesses the monkey species
    public String getSpecies() {
        return species;
    }

    // Mutator Method --sets monkey species
    public void setSpecies(String monkeySpecies) {
        species = monkeySpecies;
    }
    
    //Accesses the monkey's height
    public String getHeight() {
    	return height;
    }
   
    //Mutator Method --sets monkey's height
    public void setHeight(String monkeyHeight) {
    	height = monkeyHeight;
    }
    
    //Accessor Method -- retrieves the monkey's tail length
    public String getTailLength() {
    	return tailLength;
    }
    
    //Mutator Method -- sets the monkey's tail length
    public void setTailLength(String tail) {
    	tailLength = tail;
    }
    
    //Accessor Method --returns the monkey's body length
    public String getBodyLength() {
    	return bodyLength;
    }
    
    //Mutator Method --sets the monkey's body length
    public void setBodyLength(String length) {
    	bodyLength = length;
    }
}
