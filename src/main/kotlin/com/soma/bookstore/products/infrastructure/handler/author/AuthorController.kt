package com.soma.bookstore.products.infrastructure.handler.author

import com.soma.bookstore.products.application.use_case.author.create.AuthorCreateUseCase
import com.soma.bookstore.products.application.use_case.author.delete.AuthorDeleteUseCase
import com.soma.bookstore.products.application.use_case.author.find.AuthorFindUseCase
import com.soma.bookstore.products.application.use_case.author.find_all.AuthorFindAllUseCase
import com.soma.bookstore.products.application.use_case.author.update.AuthorUpdateUseCase
import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.infrastructure.handler.author.request.AuthorCreateRequest
import com.soma.bookstore.products.infrastructure.handler.author.request.AuthorUpdateRequest
import com.soma.bookstore.products.infrastructure.handler.author.response.AuthorResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/author")
class AuthorController(
    private val createUseCase: AuthorCreateUseCase,
    private val deleteUseCase: AuthorDeleteUseCase,
    private val updateUseCase: AuthorUpdateUseCase,
    private val findUseCase: AuthorFindUseCase,
    private val findAllUseCase: AuthorFindAllUseCase,
    private val createRequestMapper: Mapper<Author, AuthorCreateRequest>,
    private val updateRequestMapper: Mapper<Author, AuthorUpdateRequest>,
    private val responseMapper: Mapper<AuthorResponse, Author>
) {

    @Operation(
        summary = "Create new author",
        description = "Create new author",
        operationId = "create"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Author successfully created"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @PostMapping
    fun create(@RequestBody payload: AuthorCreateRequest): ResponseEntity<Void> {
        val author = createUseCase.create(
            createRequestMapper.map(payload)
        )
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{author_id}")
            .buildAndExpand(author.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @Operation(
        summary = "Find author by id",
        description = "Find author by id",
        operationId = "find"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Author successfully retrieved"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "404", description = "Author not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping("/{author_id}")
    fun find(@PathVariable("author_id") id: String): ResponseEntity<AuthorResponse> {
        return ResponseEntity.ok(
            responseMapper.map(findUseCase.find(id))
        )
    }

    @Operation(
        summary = "Find all authors",
        description = "Find all authors",
        operationId = "find all"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Authors successfully retrieved"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping
    fun findAll(): ResponseEntity<List<AuthorResponse>> {
        return ResponseEntity.ok(
            findAllUseCase.findAll().map(responseMapper::map)
        )
    }

    @Operation(
        summary = "Update author",
        description = "Update author",
        operationId = "update"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Author successfully updated"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "404", description = "Author not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @PatchMapping("/{author_id}")
    fun update(
        @RequestBody payload: AuthorUpdateRequest,
        @PathVariable("author_id") id: String
    ): ResponseEntity<AuthorResponse> {
        return ResponseEntity.ok(
            responseMapper.map(
                updateUseCase.update(updateRequestMapper.map(payload), id)
            )
        )
    }

    @Operation(
        summary = "Delete author",
        description = "Delete author",
        operationId = "delete"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Author successfully deleted"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "404", description = "Author not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @DeleteMapping("/{author_id}")
    fun delete(@PathVariable("author_id") id: String) = deleteUseCase.delete(id)

}