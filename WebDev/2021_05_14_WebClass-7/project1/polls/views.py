from django.shortcuts import render, HttpResponse, HttpResponseRedirect, reverse
from polls.models import Question, Choice


def main_page(request):

    response = "<h1>This page will show list of all questions</h1>"
    all_questions_list = Question.objects.all()
    print(all_questions_list)

    context = {
        "ques_list": all_questions_list,
    }

    return render(request, "polls/main_page.html", context)


def details(request, ques_id):

    question_qs = Question.objects.filter(pk=ques_id)

    if question_qs:
        question = question_qs[0]  # question_qs.first()

        choice_list = Choice.objects.filter(question=question)

        print(question, choice_list)

        context = {
            "question": question,
            "choice_list": choice_list,
        }

        return render(request, "polls/details.html", context=context)
    else:
        response = "Question with this id is not present."
        return HttpResponse(response)


def results(request, ques_id):
    question_qs = Question.objects.filter(pk=ques_id)

    if question_qs:
        question = question_qs.first()

        choice_list = Choice.objects.filter(question=question)

        context = {
            "question": question,
            "choice_list": choice_list,
        }

        return render(request, "polls/results.html", context=context)
    else:
        response = "Question with this id is not present."
        return HttpResponse(response)


def vote(request, ques_id):
    selected_choice_id = request.POST['choice']

    selected_choice_qs = Choice.objects.filter(pk=selected_choice_id)

    # Checking if choice with id=selected_choice_id exists or not
    if selected_choice_qs:
        selected_choice = selected_choice_qs[0]  # .first()

        selected_choice.number_of_votes += 1

        selected_choice.save()

        # response = "Voted successfully on Question with id=" + str(ques_id)
        
        # Syntax of reverse - reverse("url_name_defined_in_path", kwargs={"var_1": value_1, ...})
        # Printing reverse just to see what is it actually returning
		print(reverse('Results', kwargs={'ques_id': ques_id}))
        
        return HttpResponseRedirect(reverse("Results", kwargs={"ques_id": ques_id}))
    else:
        response = "Choice with this id is not present."
        return HttpResponse(response)
