resource "google_service_account" "this" {
  account_id   = "${var.name_prefix}splike-gke-cluster"
  display_name = "SPLIKE GKE Cluster Service Account"
}
