

public class User {
    private String name;
    private String comapanyName;
    private int yearOfJoining;
    private String createUserEmail;
    private String createUserpassword;

    public String getCreateUserEmail() {
        return createUserEmail;
    }

    public String getCreateUserpassword() {
        return createUserpassword;
    }

    public String getName() {
        return name;
    }

    public String getComapanyName() {
        return comapanyName;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComapanyName(String comapanyName) {
        this.comapanyName = comapanyName;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public User(String name, String comapanyName, int yearOfJoining) {
        this.name = name;
        this.comapanyName = comapanyName;
        this.yearOfJoining = yearOfJoining;
        this.createUserEmail = createUseremail();
        this.createUserpassword = createUserPassword();
    }
    private String createUseremail(){
        return String.format("%s_%s@%d.com",getName().toLowerCase(),getComapanyName().toLowerCase(),getYearOfJoining());

    }
    private String createUserPassword(){
        StringBuilder sb = new StringBuilder();
        sb.append(genraterandomCharacter());
        for(int i = 0; i <4 ; i++){
            sb.append(generateRandmIntegerFormLimit(10));
        }
        sb.append(getFirst5CharactersFromUserName());
        sb.append(generateRandomSpecialSymbol());
        return sb.toString();

    }
    private  String getFirst5CharactersFromUserName(){
        if(getName().length() < 5){
            int difference = 5 - getName().length();
            StringBuilder tempName = new StringBuilder(getName());
            for (int i = 0; i < difference; i++){
                tempName.append("0");
            }
            return  tempName.toString();
        }
        else{
            return getName().substring(0,5);
        }}
    private char genraterandomCharacter(){
        int randomNumberUpto26 = generateRandmIntegerFormLimit(26);
        return (char) ('a' + randomNumberUpto26);
    }
    public int generateRandmIntegerFormLimit(int limit){
        return (int) (Math.random() * limit);
    }
    private char generateRandomSpecialSymbol(){
        char[] specialSymbols =
                {
                        '!','@','#','$','%','^','&','*','(',')','{','}','[',']','|','\\',';',':','\'','\"','<','>',',','.','/','?'
                };
        int randomInteger = generateRandmIntegerFormLimit(specialSymbols.length);
        return specialSymbols[randomInteger];

    }}
class Userentry{
    public static void main(String[] args) {
        User ob = new User("Anmol","GLA",2018);
        System.out.println(ob.getCreateUserEmail());
        System.out.println(ob.getCreateUserpassword());
    }
}