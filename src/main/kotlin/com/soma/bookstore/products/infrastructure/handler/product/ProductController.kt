package com.soma.bookstore.products.infrastructure.handler.product

import com.soma.bookstore.products.application.use_case.product.create.ProductCreateUseCase
import com.soma.bookstore.products.application.use_case.product.delete.ProductDeleteUseCase
import com.soma.bookstore.products.application.use_case.product.find.ProductFindUseCase
import com.soma.bookstore.products.application.use_case.product.find_all.ProductFindAllUseCase
import com.soma.bookstore.products.application.use_case.product.find_by_author.ProductFindByAuthorUseCase
import com.soma.bookstore.products.application.use_case.product.find_by_category.ProductFindByCategoryUseCase
import com.soma.bookstore.products.application.use_case.product.update.ProductUpdateUseCase
import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.infrastructure.handler.product.request.ProductCreateRequest
import com.soma.bookstore.products.infrastructure.handler.product.request.ProductUpdateRequest
import com.soma.bookstore.products.infrastructure.handler.product.response.ProductResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
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
@RequestMapping("/product")
@Tag(name = "Products", description = "Products Management")
class ProductController(
    private val createUseCase: ProductCreateUseCase,
    private val deleteUseCase: ProductDeleteUseCase,
    private val findUseCase: ProductFindUseCase,
    private val findAllUseCase: ProductFindAllUseCase,
    private val findByAuthorUseCase: ProductFindByAuthorUseCase,
    private val findByCategoryUseCase: ProductFindByCategoryUseCase,
    private val updateUseCase: ProductUpdateUseCase,
    private val createRequestMapper: Mapper<Product, ProductCreateRequest>,
    private val updateRequestMapper: Mapper<Product, ProductUpdateRequest>,
    private val responseMapper: Mapper<ProductResponse, Product>
) {

    @Operation(
        summary = "Create new product",
        description = "Create new product",
        operationId = "create"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Product successfully created"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @PostMapping
    fun create(@RequestBody payload: ProductCreateRequest): ResponseEntity<Void> {
        val product = createUseCase.create(
            createRequestMapper.map(payload)
        )
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{category_id}")
            .buildAndExpand(product.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @Operation(
        summary = "Find product by id",
        description = "Find product by id",
        operationId = "find"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Product successfully retrieved"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "404", description = "Product not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping("/{product_id}")
    fun find(@PathVariable("product_id") id: String): ResponseEntity<ProductResponse> {
        return ResponseEntity.ok(
            responseMapper.map(
                findUseCase.find(id)
            )
        )
    }

    @Operation(
        summary = "Find all products",
        description = "Find all products",
        operationId = "find all"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Products successfully retrieved"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping
    fun findAll(): ResponseEntity<List<ProductResponse>> {
        return ResponseEntity.ok(
            findAllUseCase.findAll().map(responseMapper::map)
        )
    }

    @Operation(
        summary = "Find products by author",
        description = "Find products by author",
        operationId = "find by author"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Products successfully retrieved"),
            ApiResponse(responseCode = "404", description = "Author not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping("/findByAuthor/{author_id}")
    fun findByAuthor(@PathVariable("author_id") author_id: String): ResponseEntity<List<ProductResponse>> {
        return ResponseEntity.ok(
            findByAuthorUseCase.findByAuthor(author_id).map(responseMapper::map)
        )
    }

    @Operation(
        summary = "Find products by category",
        description = "Find products by category",
        operationId = "find by author"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Products successfully retrieved"),
            ApiResponse(responseCode = "404", description = "Category not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @GetMapping("/findByCategory/{category_id}")
    fun findByCategory(@PathVariable("category_id") category_id: String): ResponseEntity<List<ProductResponse>> {
        return ResponseEntity.ok(
            findByCategoryUseCase.findByCategory(category_id).map(responseMapper::map)
        )
    }

    @Operation(
        summary = "Update product",
        description = "Update product",
        operationId = "update"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Product successfully updated"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "404", description = "Product not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @PatchMapping("/{product_id}")
    fun update(
        @PathVariable("product_id") product_id: String,
        @RequestBody payload: ProductUpdateRequest
    ): ResponseEntity<ProductResponse> {
        return ResponseEntity.ok(
            responseMapper.map(
                updateUseCase.update(
                    updateRequestMapper.map(payload),
                    product_id
                )
            )
        )
    }

    @Operation(
        summary = "Delete product",
        description = "Delete product",
        operationId = "delete"
    )
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Product successfully deleted"),
            ApiResponse(responseCode = "400", description = "Bad request"),
            ApiResponse(responseCode = "404", description = "Product not found"),
            ApiResponse(responseCode = "500", description = "Internal server error")
        ]
    )
    @DeleteMapping("/{product_id}")
    fun delete(@PathVariable("product_id") product_id: String) = deleteUseCase.delete(product_id)
}