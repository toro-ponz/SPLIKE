resource "google_container_cluster" "this" {
  name                     = "${var.name_prefix}splike-cluster"
  remove_default_node_pool = true
  enable_shielded_nodes    = true
  initial_node_count       = var.node_pool_size
}
