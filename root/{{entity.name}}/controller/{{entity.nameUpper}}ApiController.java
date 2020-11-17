package {{path}}.{{entity.name}}.controller;

import com.apeter.blog.base.api.request.SearchRequest;
import com.apeter.blog.base.api.response.OkResponse;
import com.apeter.blog.base.api.response.SearchResponse;
import {{path}}.{{entity.name}}.api.request.{{entity.nameUpper}}Request;
import {{path}}.{{entity.name}}.api.response.{{entity.nameUpper}}FullResponse;
import {{path}}.{{entity.name}}.exception.{{entity.nameUpper}}NoExistException;
import {{path}}.{{entity.name}}.routes.{{entity.nameUpper}}ApiRoutes;
import {{path}}.{{entity.name}}.api.request.RegistrationRequest;
import {{path}}.{{entity.name}}.api.response.{{entity.nameUpper}}Response;
import {{path}}.{{entity.name}}.exception.{{entity.nameUpper}}ExistException;
import {{path}}.{{entity.name}}.mapping.{{entity.nameUpper}}Mapping;
import {{path}}.{{entity.name}}.service.{{entity.nameUpper}}ApiService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.bson.types.ObjectId;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value = "{{entity.nameUpper}} API")
public class {{entity.nameUpper}}ApiController {
    private final {{entity.nameUpper}}ApiService {{entity.name}}ApiService;

    @PostMapping({{entity.nameUpper}}ApiRoutes.ROOT)
    @ApiOperation(value = "Create", notes = "Use this when you need to create new {{entity.name}}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "{{entity.nameUpper}} already exists")
    })
    public OkResponse<{{entity.nameUpper}}FullResponse> registration(@RequestBody RegistrationRequest request) throws {{entity.nameUpper}}ExistException {
//        Integer i = 3/0;

        return OkResponse.of({{entity.nameUpper}}Mapping.getInstance().getResponseFullMapping().convert({{entity.name}}ApiService.registration(request)));
    }

    @GetMapping({{entity.nameUpper}}ApiRoutes.BY_ID)
    @ApiOperation(value = "Find {{entity.name}} by if", notes = "Use this when you need to find {{entity.name}} by id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success"),
                    @ApiResponse(code = 404, message = "{{entity.nameUpper}} not found")
            }
    )
    public OkResponse<{{entity.nameUpper}}Response> byId(
            @ApiParam(value = "{{entity.nameUpper}} id") @PathVariable ObjectId id
    ) throws ChangeSetPersister.NotFoundException {
        return OkResponse.of({{entity.nameUpper}}Mapping.getInstance().getResponseFullMapping().convert(
                {{entity.name}}ApiService.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new)
        ));
    }

    @GetMapping({{entity.nameUpper}}ApiRoutes.ROOT)
    @ApiOperation(value = "Search {{entity.name}}s", notes = "Use this when you need to search {{entity.name}}s by last name first name or email with skip and size of the response")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success")
            }
    )
    public OkResponse<SearchResponse<{{entity.nameUpper}}Response>> search(
            @ModelAttribute SearchRequest request
    ) {
        return OkResponse.of({{entity.nameUpper}}Mapping.getInstance().getSearchMapping().convert(
                {{entity.name}}ApiService.search(request)
        ));
    }

    @PutMapping({{entity.nameUpper}}ApiRoutes.BY_ID)
    @ApiOperation(value = "update {{entity.name}}", notes = "Use this when you need to update {{entity.name}}")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success")
            }
    )
    public OkResponse<{{entity.nameUpper}}FullResponse> update(
            @ApiParam(value = "{{entity.nameUpper}} id") @PathVariable String id,
            @RequestBody {{entity.nameUpper}}Request request
    ) throws {{entity.nameUpper}}NoExistException {
        return OkResponse.of({{entity.nameUpper}}Mapping.getInstance().getResponseFullMapping().convert(
                {{entity.name}}ApiService.update(request)
        ));
    }

    @DeleteMapping({{entity.nameUpper}}ApiRoutes.BY_ID)
    @ApiOperation(value = "delete {{entity.name}} by id", notes = "Use this when you need to delete {{entity.name}} by id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success")
            }
    )
    public OkResponse<String> deleteById(
            @ApiParam(value = "{{entity.nameUpper}} id")
            @PathVariable ObjectId id
    ) {
        {{entity.name}}ApiService.deleteById(id);
        return OkResponse.of(HttpStatus.OK.toString());
    }
}
