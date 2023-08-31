package wizmokeycloak.domain;

import wizmokeycloak.domain.*;
import wizmokeycloak.infra.AbstractEvent;
import java.util.*;
import lombok.*;
import java.time.LocalDate;


//<<< DDD / Domain Event
@Data
@ToString
public class CompanyUpdated extends AbstractEvent {

    private String code;
    private String name;
    private String industry;
    private Date foundedDate;
    private String tenantId;

    public CompanyUpdated(Company aggregate){
        super(aggregate);
    }
    public CompanyUpdated(){
        super();
    }
}
//>>> DDD / Domain Event

window.$HandleBars.registerHelper('checkToppings', function (toppingPlatforms, checkTopping) {
    var hasToppings = false;
    try{
        for(var i=0; i<toppingPlatforms.length; i++){
            if(toppingPlatforms[i].includes(checkTopping)){
                hasToppings = true;
            }
        }

    return hasToppings;

    } catch(e){
        console.log(e)
    }
});

window.$HandleBars.registerHelper('checkDateType', function (fieldDescriptors) {
    for(var i = 0; i < fieldDescriptors.length; i ++ ){
        if(fieldDescriptors[i] && fieldDescriptors[i].className == 'Date'){
            return "import java.util.Date; \n"
        }
    }
});

window.$HandleBars.registerHelper('checkBigDecimal', function (fieldDescriptors) {
    for(var i = 0; i < fieldDescriptors.length; i ++ ){
        if(fieldDescriptors[i] && fieldDescriptors[i].className.includes('BigDecimal')){
            return "import java.math.BigDecimal;";
        }
    }
});

window.$HandleBars.registerHelper('validate', function (aggregate, options) {
    var keys = Object.keys(aggregate)
    if(keys.length > 1) {
        return options.fn(this);
    }
    return options.inverse(this);


});


