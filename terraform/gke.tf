module "prd_splike_cluster" {
  count          = 1
  source         = "./modules/cluster"
  name_prefix    = "prd-"
  node_pool_size = 1
}
