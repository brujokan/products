package com.soma.bookstore.products.infrastructure.handler.product.mapper

import com.soma.bookstore.products.application.use_case.author.find.AuthorFindUseCase
import com.soma.bookstore.products.application.use_case.category.find.CategoryFindUseCase
import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.infrastructure.handler.product.request.ProductCreateRequest
import org.springframework.stereotype.Component

@Component
class ProductCreateRequestMapper(
    private val findAuthorUseCase: AuthorFindUseCase,
    private val findCategoryUseCase: CategoryFindUseCase
): Mapper<Product, ProductCreateRequest> {

    override fun map(input: ProductCreateRequest): Product {
        return Product(
            title = input.title,
            description = input.description,
            language = input.language,
            idNumber = input.idNumber,
            publicationDate = input.publicationDate,
            author = findAuthorUseCase.find(input.author),
            category = findCategoryUseCase.find(input.category)
        )
    }
}