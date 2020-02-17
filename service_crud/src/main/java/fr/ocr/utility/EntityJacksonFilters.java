package fr.ocr.utility;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

@Component
abstract class EntityJacksonFilters<T> {
    private String nameOfFilter;
    private String [] listOfExceptions;

    public String getNameOfFilter() {
        return nameOfFilter;
    }

    public void setNameOfFilter(String nameOfFilter) {
        this.nameOfFilter = nameOfFilter;
    }

    public String[] getListOfExceptions() {
        return listOfExceptions;
    }

    public void setListOfExceptions(String[] listOfExceptions) {
        this.listOfExceptions = listOfExceptions;
    }

    public MappingJacksonValue filtersOnAttributes  (T x ) {

        SimpleBeanPropertyFilter filtre = SimpleBeanPropertyFilter.serializeAllExcept(this.listOfExceptions);

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter(nameOfFilter, filtre);

        MappingJacksonValue filteredReference = new MappingJacksonValue(x);

        filteredReference.setFilters(filterProvider);

        return filteredReference;
    }
}
