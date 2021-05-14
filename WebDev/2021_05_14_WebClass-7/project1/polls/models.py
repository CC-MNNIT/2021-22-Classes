from django.db import models

# Create your models here.


class Question(models.Model):  # Model class from models module is inherited in class Question.

    question_text = models.CharField(max_length=1000, verbose_name="Question Text")

    publication_date = models.DateField(verbose_name="Publication Date")

    def __str__(self):  # A method is declared so that in admin panel Text of Question is displayed.
        return self.question_text


class Choice(models.Model):

    choice_text = models.CharField(max_length=200, verbose_name="Choice Text")

    number_of_votes = models.IntegerField(verbose_name="Number of Votes")

    question = models.ForeignKey(Question, on_delete=models.CASCADE)

    def __str__(self):
        return self.choice_text
