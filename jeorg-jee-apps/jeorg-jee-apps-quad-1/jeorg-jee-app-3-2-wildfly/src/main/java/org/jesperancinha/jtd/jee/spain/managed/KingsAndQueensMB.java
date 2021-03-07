package org.jesperancinha.jtd.jee.spain.managed;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;

@RequestScoped
@Named("kingsAndQueensMB")
public class KingsAndQueensMB {

    private String filterString;
    private String result;

    public List<String> allKingsAndQueensHabsburg() {
        return List.of("Carlos I", "Felipe II", "Felipe III", "Felipe IV", "Carlos II");
    }

    public String getFilterString() {
        return filterString;
    }

    public void setFilterString(String filterString) {
        this.filterString = filterString;
    }

    public void searchFrom() {
        if(Objects.nonNull(filterString)) {
            this.result = allKingsAndQueensHabsburg().stream().filter(kq -> kq.contains(filterString)).findAny().orElse(null);
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

