## Amnesty International Report Viewer
Work in Progress: A Play-Scala backend web app that classifies user-uploaded torture incidents into military or civilian cases, based on the ones from Amnesty International's Annual Report ([example](https://www.amnesty.org/en/documents/POL10/001/1962/en/)) from the years 1962-2007.

### Initial Issues List

todo: convert to detailed issues

##### Users
+ A User can sign up for an account in the web app
+ A User can log in to the web app

##### Reports
+ (done✓) A User can create a torture Report 
+ (done✓) A User can view a torture Report 
+ (done✓) A User can view a list of public torture Reports 
+ A User can view a list of private torture Reports that belongs to them

##### Feature Rules
+ A User can create a Feature Rule from 3 options: Regex, Word Distance, or Aggregation/Composition of Feature Rules
+ A User can edit a Feature Rule
+ A User can view a Feature Rule
+ A User can delete a Feature Rule

##### Points
+ A User can create a Point from a Feature Rule and a torture report 
+ A User can view a Point
+ A User can view a list of Points they've created
+ A User can edit a Point
+ A User can delete a Point

##### Sets
+ A User can create a Set of Points via manual Point selection or selecting a Feature Rule and a list of torture reports
+ A User can edit a Set
+ A User can view a Set
+ A User can view a list of Sets
+ A User can delete a Set

##### Linear Separator
+ A Linear Separator can classify a set of 2D points into positive(military) or negative(civilian) categories 

##### Corpus
+ A User can create a Corpus of classified reports from a Set of Points that use the same Feature Rule. A classified report is either military or civilian. If a report has military and civilian features then it should be edited to break down into multiple reports for now
+ A User can edit a Corpus
+ A User can view a Corpus
+ A User can view a list of public Corpi
+ A User can view a list of private Corpi that they own
+ A User can delete a Corpus

### Local Development Setup
##### Browser Viewing
`$ cd $PROJECT_ROOT`

`$ sbt run`

Point your browser at [http://localhost:9000/amnesty-report](http://localhost:9000/amnesty-report)

##### Unit Test Running
todo
