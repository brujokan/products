package com.soma.bookstore.products.infrastructure.handler.category

import com.soma.bookstore.products.application.use_case.category.create.CategoryCreateUseCase
import com.soma.bookstore.products.application.use_case.category.delete.CategoryDeleteUseCase
import com.soma.bookstore.products.application.use_case.category.find.CategoryFindUseCase
import com.soma.bookstore.products.application.use_case.category.find_all.CategoryFindAllUseCase
import com.soma.bookstore.products.application.use_case.category.update.CategoryUpdateUseCase
import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.infrastructure.handler.category.request.CategoryCreateRequest
import com.soma.bookstore.products.infrastructure.handler.category.request.CategoryUpdateRequest
import com.soma.bookstore.products.infrastructure.handler.category.response.CategoryResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/category")
@Tag(name = "Categories", description = "Categories Management")
class CategoryController(
    private val createUseCase: CategoryCreateUseCase,
    private val updateUseCase: CategoryUpdateUseCase,
    private val findUseCase: CategoryFindUseCase,
    private val findAllUseCase: CategoryFindAllUseCase,
    private val deleteUseCase: CategoryDeleteUseCase,
    private val createRequestMapper: Mapper<Category, CategoryCreateRequest>,
    private val updateRequestMapper: Mapper<Category, CategoryUpdateRequest>,
    private val responseMapper: Mapper<CategoryResponse, Category>
) {

    @Operation(
        summary = "Create new category",
        description = "Create new category",
        operationId = "create"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Category successfully created"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @PostMapping
    fun create(@RequestBody payload: CategoryCreateRequest): ResponseEntity<Void> {
        val category = createUseCase.create(
            createRequestMapper.map(payload)
        )
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{category_id}")
            .buildAndExpand(category.id).toUri()
        return ResponseEntity.created(uri).build()
    }


    @Operation(
        summary = "Find category by id",
        description = "Find category by id",
        operationId = "find"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Category successfully retrieved"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "404", description = "Category not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping("/{category_id}")
    fun find(@PathVariable("category_id") id: String): ResponseEntity<CategoryResponse> {
        return ResponseEntity.ok(
            responseMapper.map(
                findUseCase.find(id)
            )
        )
    }

    @Operation(
        summary = "Find all categories",
        description = "Find all categories",
        operationId = "find all"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Categories successfully retrieved"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping
    fun find(): ResponseEntity<List<CategoryResponse>> {
        return ResponseEntity.ok(
            findAllUseCase.findAll().map(responseMapper::map)
        )
    }

    @Operation(
        summary = "Update category",
        description = "Update category",
        operationId = "update"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Category successfully updated"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "404", description = "Category not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @PatchMapping("/{category_id}")
    fun update(
        @PathVariable("category_id") id: String,
        @RequestBody payload: CategoryUpdateRequest
    ): ResponseEntity<CategoryResponse> {
        return ResponseEntity.ok(
            responseMapper.map(updateUseCase.update(updateRequestMapper.map(payload), id))
        )
    }

    @Operation(
        summary = "Delete category",
        description = "Delete category",
        operationId = "delete"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Category successfully deleted"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "404", description = "Category not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @DeleteMapping("/{category_id}")
    fun delete(@PathVariable("category_id") id: String) = deleteUseCase.delete(id)
}