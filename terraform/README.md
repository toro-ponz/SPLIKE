## splike by Terraform

### Getting Started

0.Install Terraform

refs: https://learn.hashicorp.com/tutorials/terraform/install-cli#install-terraform

```shell
sudo apt-get update && sudo apt-get install -y gnupg software-properties-common curl
curl -fsSL https://apt.releases.hashicorp.com/gpg | sudo apt-key add -
sudo apt-add-repository "deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main"
sudo apt-get update && sudo apt-get install terraform
```

1.Create Service Account for Terraform

```shell
gcloud iam service-accounts create terraform \
  --display-name "Service Account for Terraform" \
  --project splike

gcloud projects add-iam-policy-binding splike \
  --member serviceAccount:terraform@splike.iam.gserviceaccount.com \
  --role roles/owner
```

2.Create Keys

```shell
mkdir -p ~/.gcp/credentials
gcloud iam service-accounts keys create ~/.gcp/credentials/terraform.json \
  --iam-account terraform@splike.iam.gserviceaccount.com \
  --project splike
chown 400 ~/.gcp/credentials/terraform.json
```

3.Set Environment Variable

refs: https://registry.terraform.io/providers/hashicorp/google/latest/docs/guides/getting_started#adding-credentials

```shell
echo 'export GOOGLE_APPLICATION_CREDENTIALS="~/.gcp/credentials/terraform.json"' >> ~/.profile
```

4.Setup Terraform

```shell
# Login to Terraform Cloud
terraform login

terraform init
terraform plan
terraform apply
```
