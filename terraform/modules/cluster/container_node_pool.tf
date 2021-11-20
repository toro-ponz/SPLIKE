resource "google_container_node_pool" "splike" {
  name       = "${var.name_prefix}splike-cluster-node-pool"
  cluster    = google_container_cluster.this.name
  node_count = var.node_pool_size

  node_config {
    preemptible  = true
    machine_type = var.node_pool_machine_type

    service_account = google_service_account.this.email
    oauth_scopes    = [
      "https://www.googleapis.com/auth/cloud-platform"
    ]
  }
}
