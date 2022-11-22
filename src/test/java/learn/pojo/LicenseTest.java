package learn.pojo;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import learn.pojo.License;
import org.junit.Test;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first, is(second));
    }
}