package com.javarush.task.task28.task2810.vo;

import java.util.Objects;

public class Vacancy {

   private String title;
   private String salary;
   private String city;
   private String companyName;
   private String siteName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary=salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city=city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName=companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy=(Vacancy) o;
        return title.equals(vacancy.title) &&
                Objects.equals(salary, vacancy.salary) &&
                city.equals(vacancy.city) &&
                companyName.equals(vacancy.companyName) &&
                siteName.equals(vacancy.siteName) &&
                url.equals(vacancy.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, salary, city, companyName, siteName, url);
    }

    @Override
    public String toString() {
        final StringBuilder sb=new StringBuilder("Vacancy{");
        sb.append("title='").append(title).append('\'');
        sb.append(", salary='").append(salary).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", siteName='").append(siteName).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName=siteName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url=url;
    }

    private String url;
}
