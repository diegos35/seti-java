terraform {
  required_providers {
    mongodbatlas = {
      source  = "mongodb/mongodbatlas"
      version = "~> 1.8.0"
    }
  }
}

provider "mongodbatlas" {
  public_key  = var.public_key
  private_key = var.private_key
}

resource "mongodbatlas_project" "example" {
  name   = "Franchise API"
  org_id = "61b267d0012d6337546ffd00"
}

resource "mongodbatlas_cluster" "example" {
  project_id               = mongodbatlas_project.example.id
  name                     = "MyCluster"
  cluster_type             = "REPLICASET"
  provider_name            = "AWS"
  provider_region_name     = "US_EAST_1"
  provider_instance_size_name = "M2"
  backup_enabled           = false
}

resource "mongodbatlas_database_user" "example" {
  username           = "test-user"
  password           = "securePassword123"
  project_id         = mongodbatlas_project.example.id
  auth_database_name = "admin"

  roles {
    role_name     = "readWriteAnyDatabase"
    database_name = "admin"
  }
}

variable "public_key" {
  description = "Public key for MongoDB Atlas"
  type        = string
}

variable "private_key" {
  description = "Private key for MongoDB Atlas"
  type        = string
}
