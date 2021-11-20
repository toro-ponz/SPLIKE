terraform {
  required_version = "~> 1.0.0"

  required_providers {
    google = {
      source  = "hashicorp/google"
      version = "~> 4.0.0"
    }
    google-beta = {
      source  = "hashicorp/google-beta"
      version = "~> 4.0.0"
    }
  }

  backend "remote" {
    hostname     = "app.terraform.io"
    organization = "splike"

    workspaces {
      name = "root"
    }
  }
}

provider "google" {
  project = "splike"
  region  = "asia-northeast1"
  zone    = "asia-northeast1-a"

  # FIXME:
  credentials = file("account.json")
}

provider "google-beta" {
  project = "splike"
  region  = "asia-northeast1"
  zone    = "asia-northeast1-a"

  # FIXME:
  credentials = file("account.json")
}
