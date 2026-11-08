import jenkins.model.Jenkins
import hudson.security.HudsonPrivateSecurityRealm
import hudson.security.FullControlOnceLoggedInAuthorizationStrategy

def jenkins = Jenkins.get()

// Логин и пароль берём из переменных окружения
def user = System.getenv("JENKINS_ADMIN_ID")
def pass = System.getenv("JENKINS_ADMIN_PASSWORD")

// Включаем встроенную базу пользователей Jenkins и создаём администратора
def realm = new HudsonPrivateSecurityRealm(false)
realm.createAccount(user, pass)
jenkins.setSecurityRealm(realm)

// Права: вошедший может всё, анонимный не видит ничего
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
jenkins.setAuthorizationStrategy(strategy)

jenkins.save()