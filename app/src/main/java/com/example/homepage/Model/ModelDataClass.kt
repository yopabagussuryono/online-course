package com.example.homepage.Model

class ModelDataClass {

    var className : String = "Class Name"
        get() = field
        set(value) {field=value}

    var classType : String = "Class Type"
        get() = field
        set(value) {field=value}

    var studentSize : Int = 0
        get() = field
        set(value) {field=value}

    var teacherName : String = "Teacher Name"
        get() = field
        set(value) {field=value}

    constructor(className: String, classType: String, studentSize: Int, teacherName: String) {
        this.className = className
        this.classType = classType
        this.studentSize = studentSize
        this.teacherName = teacherName
    }


    override fun toString(): String {
        return "ModelDataClass(className='$className'," +
                "classType='$classType', studentSize=$studentSize, teacherName='$teacherName')"
    }


}