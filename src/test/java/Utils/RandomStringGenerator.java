package Utils;
import org.apache.commons.lang3.RandomStringUtils;
public class RandomStringGenerator {

    public String randomStringGenerator(int minLength,int maxLength){

        return RandomStringUtils.randomAlphanumeric(minLength,maxLength);


    }
}
