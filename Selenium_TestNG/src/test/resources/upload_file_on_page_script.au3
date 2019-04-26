;$filePath = "C:\Users\User\Desktop\testSheet.xlsx"
Func setPath($path)
	Sleep(500)
	ControlFocus("Otwieranie", "", "Edit1")
	Sleep(500)
	ControlSetText("Otwieranie", "", "Edit1", $path)
	Sleep(500)
	ControlClick("Otwieranie", "", "Button1")
EndFunc

Call("setPath", $CmdLine[1])