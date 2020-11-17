package {{path}}.{{entity.name}}.api.response;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.bson.types.ObjectId;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@ApiModel(value = "{{entity.name}} response", description = "{{entity.name}} short data")
public class {{entity.nameUpper}}Response {
    {{#entityProperties}}
        protected {{type}} {{name}};
    {{/entityProperties}}
}
