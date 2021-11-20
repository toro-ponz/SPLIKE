resource "google_artifact_registry_repository" "this" {
  provider = google-beta

  repository_id = var.name
  description   = "Microservice of ${var.name} repository."
  format        = "DOCKER"

  // https://github.com/hashicorp/terraform-provider-google/issues/10436
  location = "asia-northeast1"
}
