package com.metafisa.myanubhav.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ValueEventListener
import com.metafisa.myanubhav.R
import com.metafisa.myanubhav.adapter.FaqSalcalAdapter
import com.metafisa.myanubhav.models.FaqSalcal

class SalaryCalculatorFragment : Fragment() {

    val faqSalcalList = ArrayList<FaqSalcal>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_salary_calculator, container, false)

        val recyclerview: RecyclerView =v.findViewById(R.id.recyclerView)

        // FaqSalCal Adding

        faqSalcalList.add(
            FaqSalcal("What is Salary and it's components?",
                "Salary is a fixed amount of money or compensation paid to an employee by an employer in return for work performed. It is usually paid at the end of each month.\n" +
                        "The salary components vary with different employers. Below is a list of the most common salary components.\n" +
                        "Basic Salary: It is a fixed base part of an individual’s compensation package. Basic Salary is taxable & usually 35-50% of the total gross salary. However, it is usually determined by taking an employee’s designation, experience & industry of work into account.\n" +
                        "House Rent Allowance (HRA): It is a monetary benefit given to employees by companies for expenses related to rented accommodation. It is a fully taxable component if you do not stay in rented property.\n" +
                        "Leave Travel Allowance (LTA): It is a type of allowance which is provided by the employer to his employee who is travelling on leave from work to cover his travel expenses. LTA is an important component of the salary of the employee as it is eligible for income tax exemption as per the Income Tax Act, 196.\n" +
                        "Special Allowance: Special allowance is a fixed amount that is given to employees over and above the basic salary in order to meet certain requirements. It is a fully taxable component of your salary.\n" +
                        "Bonus: It is a performance based incentive given to the employee by their employer. The entire bonus amount is fully taxable.\n" +
                        "Employee provident fund: It is an investment made by both the employer and employee. Each contributes 12% of the employee’s basic salary towards EPF. The lump-sum amount of this acts as an employee's retirement benefits scheme. Contribution is available for a deduction under Section 80C of the Income Tax Act, 1961.\n" +
                        "Professional Tax: It is the tax levied and collected by the state governments in India. It is a direct tax and the maximum amount payable per year is INR 2,500.\n" +
                        "Calculating the salary is complicated as it includes various aspects. People prefer using salary calculator tool in India to save time and effort")
        )
        faqSalcalList.add(
            FaqSalcal("What is the Salary Calculator?","The salary calculator or take home salary calculator is a tool that calculates your in-hand salary based on the Cost To Company (CTC) or total salary package after all taxation and deductions.\n" +
                    "The salary calculator will show you all the deductions such as the employer and employee provident fund, professional tax, employee insurance, income tax and the take-home salary.")
        )

        faqSalcalList.add(
            FaqSalcal("How to use the MyAnubhav salary Calculator ?","The MyAnubhav Salary Calculator calculates in-hand or take-home salary instantly.\n" +
                    "To use the MyAnubhav Salary Calculator, follow below steps.\n" +
                    "Enter company name, designation and your yearly cost to the company or the CTC.\n" +
                    "Select the tax regime based on your preference.\n" +
                    "Once you submit all the required details, It will instantly calculate and display your take home monthly salary along with other components such as basic salary, HRA, professional tax, EPF and income tax.\n" +
                    "You can edit/update all the information and take home salary will be updated instantly.")
        )
        faqSalcalList.add(
            FaqSalcal("What is the difference between CTC & Take home Salary ?","CTC is simply “Cost to Company” i.e. in the total calculation of salary package including all monetary & non-monetary benefits spent on an employee by the company without any tax deductions.\n" +
                    "Take Home Salary is the total salary which an employee gets after all necessary tax and other deductions are made.")
        )
        faqSalcalList.add(
            FaqSalcal("What is Employers Provident Fund?","Employers Provident fund is an investment made both by the employer and an employee each month towards Employees Provident Fund. The lump sum amount of this acts as an employee's retirement benefits scheme.\n" +
                    "This amount is directly deposited in the employee’s PF account.\n" +
                    "Please note that Employer Provident Fund (EPF) and Employee’s PF contribution are two different things.")
        )
        val faqSalcalAdapter = FaqSalcalAdapter(faqSalcalList)
        recyclerview.adapter=faqSalcalAdapter
        recyclerview.setHasFixedSize(true)
        return v

    }

}