package org.example;

import java.util.Objects;

public class Student {

    public  static class StudentBuilder{
        private String id;
        private String name;
        private String email;
        private String mobileNumber;
        private String age;
        private String address;
        private String gender;

        public StudentBuilder(){}
        public Student build(){
            return new Student(this);
        }

        public StudentBuilder id(String id)
        {
            this.id=id;
            return this;
        }
        public StudentBuilder name(String name)
        {
            this.name=name;
            return this;
        }
        public StudentBuilder email(String email)
        {
            this.email=email;
            return this;
        }
        public StudentBuilder mobileNumber(String mobileNumber)
        {
            this.mobileNumber=mobileNumber;
            return this;
        }
        public StudentBuilder age(String age)
        {
            this.age=age;
            return this;
        }
        public StudentBuilder address(String address)
        {
            this.address=address;
            return this;
        }
        public StudentBuilder gender(String gender)
        {
            this.gender=gender;
            return this;
        }
    }
    private String id;
    private String name;
    private String email;
    private String mobileNumber;
    private String age;
    private String address;
    private String gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) && Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(mobileNumber, student.mobileNumber) && Objects.equals(age, student.age) && Objects.equals(address, student.address) && Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, mobileNumber, age, address, gender);
    }

    public Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.mobileNumber = builder.mobileNumber;
        this.age = builder.age;
        this.address = builder.address;
        this.gender = builder.gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
