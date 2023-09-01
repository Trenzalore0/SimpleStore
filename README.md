# A simple store

<p>This project is to use Spring-Boot in back-end with java and ReactJs with typescript.</p>

## Database struct

<p>A simple representation of database</p>

```js
{
  customer: {
    id,
    name,
    email,
    password,
    created_at,
    updated_at
  },

  address: {
    id,
    customer,
    country,
    state,
    city,
    street,
    zipcode,
    created_at,
    updated_at
  },
  
  payments: {
    id,
    customer,
    number,
    name,
    validate,
    code
  },
  
  product: {
    id,
    name,
    description,
    value,
    sku,
    url,
    stock,
    created_at,
    updated_at,
    deleted
  },
  
  quote: {
    id,
    customer,
    products[]
    value
  },
  
  order: {
    id,
    quote,
    base_value,
    shipping_address,
    shipping_value,
    total_value,
    payment
  }
}
```

