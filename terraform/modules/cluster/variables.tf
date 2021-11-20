variable "name_prefix" {
  type = string
}

variable "node_pool_machine_type" {
  type    = string
  default = "e2-medium"
}
variable "node_pool_size" {
  type = number
}
