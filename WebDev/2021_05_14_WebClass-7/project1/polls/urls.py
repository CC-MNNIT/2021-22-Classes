from django.urls import path
from polls import views


urlpatterns = [
    path('', views.main_page, name="Main Page"),
    # Eg: http://127.0.0.1:8000/polls

    path('<int:ques_id>/details/', views.details, name="Details"),
    # Eg: http://127.0.0.1:8000/polls/1/details	, where ques_id=1

    path('<int:ques_id>/results/', views.results, name="Results"),
    # Eg: http://127.0.0.1:8000/polls/1/results , where ques_id=1

    path('<int:ques_id>/vote/', views.vote, name="Vote"),
    # Eg: http://127.0.0.1:8000/polls/1/vote , where ques_id=1

]

