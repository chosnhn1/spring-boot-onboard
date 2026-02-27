#!/bin/bash

curl localhost:8080/api/todos/v2 -X POST \
  -H "Content-Type: application/json" \
  -d '{"title": "Test Todo", "description": "Test Description"}'
