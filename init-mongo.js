db.createUser(
	{
		user: "luis",
		pwd: "1234",
		roles: [
			{
				role: "readWrite",
				db: "products"
			}
		]
	}
)