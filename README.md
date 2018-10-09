**Certbot Validator**

Pod that can be spinned to let Letsencrypt validate the domain

Add the following to the right namespace of your cluster:

Kubernetes service:

`sed 's/{{namespace}}/<<namespace name>>/' service.yaml | kubectl apply -n <<namespace name>> -f -`

Kubernetes deployment:

`sed 's/{{namespace}}/<<namespace name>>/; s/{{repository}}/<<docker_repository_name>>/' deployment.yaml | kubectl apply -n <<namespace name>> -f -`

Check if the ingress serviceName and host are right:

`
apiVersion: extensions/v1beta1
kind: Ingress
metadata:
  name: certbot-ingress
  namespace: {{namespace}}
spec:
  rules:
  - host: your.hostname.here <-- **host == certbot hostname**
    http:
      paths:
      - backend:
          serviceName: certbot-validator <-- **The name of the service defined above**
          servicePort: http
`
