package br.com.dev.mods.camel.typeconverter;

import org.apache.camel.Converter;
import org.apache.camel.TypeConverter;
import org.apache.camel.TypeConverters;
import org.springframework.stereotype.Component;

/**
 * @author marcosrufino
 * @created 08/03/2020 - 17:42
 **/

@Converter
public class MyPersonTypeConverter implements TypeConverters {




    /**
     * Converts a String in the format of "firstName|lastName" to a {@link MyPerson}.
     */
    @Converter
    public MyPerson convertStringToMyPerson(String string){

        int index = string.indexOf("|");
        if(index > 0){
            MyPerson myPerson = new MyPerson(string.substring(0, index), string.substring(index+1));
            return myPerson;
        }
        throw new IllegalArgumentException("String must be in format of '<firstName>|<lastName>'");
    }
}
